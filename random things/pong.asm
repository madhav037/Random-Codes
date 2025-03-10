; Pong Game in Assembly (NASM) for DOS, Mode 13h
; Improvements:
;   - Uses BIOS timer tick (40h:6Ch) for smoother animation.
;   - Enhanced collision detection: Adjusts ball vertical velocity based on impact position.
;   - Scorekeeping: Increments score on paddle hits and displays score on exit.
; Assemble with: nasm -f bin pong.asm -o pong.com

org 100h            ; COM file start

;--------------------------------------
; Constants and Definitions
;--------------------------------------
VIDEO_SEG      equ 0A000h
SCREEN_WIDTH   equ 320
SCREEN_HEIGHT  equ 200

; Paddle definitions
PADDLE_HEIGHT  equ 30
PADDLE_WIDTH   equ 5
LEFT_PADDLE_X  equ 10
RIGHT_PADDLE_X equ (SCREEN_WIDTH - 10 - PADDLE_WIDTH)

; Ball definitions
BALL_SIZE      equ 3

;--------------------------------------
; Data Section
;--------------------------------------
left_paddle_y   dw (SCREEN_HEIGHT/2 - PADDLE_HEIGHT/2)
right_paddle_y  dw (SCREEN_HEIGHT/2 - PADDLE_HEIGHT/2)

ball_x   dw (SCREEN_WIDTH/2)
ball_y   dw (SCREEN_HEIGHT/2)
ball_dx  dw 1
ball_dy  dw 1

score    dw 0

; For exit message (text mode)
score_msg db 13, 10, "Score: $"
score_buf db "0000$",0

;--------------------------------------
; Code Section
;--------------------------------------
start:
    ; Set VGA mode 13h (320x200, 256 colors)
    mov ax, 0013h
    int 10h

main_loop:
    ; Clear screen (fill video memory with black)
    call clear_screen

    ; Draw paddles and ball
    call draw_paddles
    call draw_ball

    ; Process keyboard input (including ESC to exit)
    call read_keys

    ; Update ball position and handle collisions
    call update_ball

    ; Wait for the next BIOS timer tick for smoother animation
    call wait_tick

    jmp main_loop

;--------------------------------------
; Subroutine: clear_screen
; Clears video memory (Mode 13h) to black.
;--------------------------------------
clear_screen:
    mov ax, VIDEO_SEG
    mov es, ax
    xor di, di
    mov cx, SCREEN_WIDTH * SCREEN_HEIGHT / 2
    xor ax, ax
    rep stosw
    ret

;--------------------------------------
; Subroutine: draw_paddles
; Draws left and right paddles (color 15 = white)
;--------------------------------------
draw_paddles:
    ; --- Left Paddle ---
    mov ax, VIDEO_SEG
    mov es, ax
    mov ax, [left_paddle_y]
    push ax
    call mul_screen_width   ; AX = left_paddle_y * SCREEN_WIDTH
    pop bx
    add ax, LEFT_PADDLE_X
    mov di, ax
    mov dx, PADDLE_HEIGHT
.left_paddle_row:
    push di
    mov cx, PADDLE_WIDTH
    mov al, 15
.left_paddle_draw:
    stosb
    loop .left_paddle_draw
    pop di
    add di, SCREEN_WIDTH - PADDLE_WIDTH
    dec dx
    jnz .left_paddle_row

    ; --- Right Paddle ---
    mov ax, VIDEO_SEG
    mov es, ax
    mov ax, [right_paddle_y]
    push ax
    call mul_screen_width   ; AX = right_paddle_y * SCREEN_WIDTH
    pop bx
    add ax, RIGHT_PADDLE_X
    mov di, ax
    mov dx, PADDLE_HEIGHT
.right_paddle_row:
    push di
    mov cx, PADDLE_WIDTH
    mov al, 15
.right_paddle_draw:
    stosb
    loop .right_paddle_draw
    pop di
    add di, SCREEN_WIDTH - PADDLE_WIDTH
    dec dx
    jnz .right_paddle_row
    ret

;--------------------------------------
; Subroutine: mul_screen_width
; Multiplies AX by SCREEN_WIDTH (320).
;--------------------------------------
mul_screen_width:
    mov bx, SCREEN_WIDTH
    mul bx                ; DX:AX = AX * BX (result fits in AX)
    ret

;--------------------------------------
; Subroutine: draw_ball
; Draws the ball (a BALL_SIZE x BALL_SIZE square in color 4 = red)
;--------------------------------------
draw_ball:
    mov ax, VIDEO_SEG
    mov es, ax
    mov ax, [ball_y]
    push ax
    call mul_screen_width
    pop bx
    add ax, [ball_x]
    mov di, ax
    mov dx, BALL_SIZE
.ball_row:
    push di
    mov cx, BALL_SIZE
    mov al, 4
.ball_draw:
    stosb
    loop .ball_draw
    pop di
    add di, SCREEN_WIDTH - BALL_SIZE
    dec dx
    jnz .ball_row
    ret

;--------------------------------------
; Subroutine: wait_tick
; Waits until the BIOS timer tick (stored at 40h:6Ch) increments.
;--------------------------------------
wait_tick:
    push ax
    push bx
    mov ax, 0040h
    mov es, ax
    mov ax, word [es:6Ch]
.wait_loop:
    mov bx, word [es:6Ch]
    cmp bx, ax
    je .wait_loop
    pop bx
    pop ax
    ret

;--------------------------------------
; Subroutine: read_keys
; Reads key input via BIOS INT 16h.
; Controls:
;   - Left paddle: 'W' (scan code 11h) up, 'S' (scan code 1Fh) down.
;   - Right paddle: Up arrow (48h) up, Down arrow (50h) down.
;   - ESC (1Bh) exits the game.
;--------------------------------------
read_keys:
    mov ah, 01h
    int 16h
    jz .no_key          ; No key pressed
    mov ah, 00h
    int 16h             ; Get the key (AL = scan code)
    cmp al, 1Bh         ; ESC key check
    je exit_game
    ; Check for left paddle keys
    cmp al, 11h         ; 'W'
    je left_up
    cmp al, 1Fh         ; 'S'
    je left_down
    ; Check for right paddle keys
    cmp al, 48h         ; Up arrow
    je right_up
    cmp al, 50h         ; Down arrow
    je right_down
.no_key:
    ret

left_up:
    mov ax, [left_paddle_y]
    cmp ax, 0
    je left_up_done
    dec ax
    mov [left_paddle_y], ax
left_up_done:
    ret

left_down:
    mov ax, [left_paddle_y]
    add ax, PADDLE_HEIGHT
    cmp ax, SCREEN_HEIGHT
    ja left_down_done
    mov ax, [left_paddle_y]
    inc ax
    mov [left_paddle_y], ax
left_down_done:
    ret

right_up:
    mov ax, [right_paddle_y]
    cmp ax, 0
    je right_up_done
    dec ax
    mov [right_paddle_y], ax
right_up_done:
    ret

right_down:
    mov ax, [right_paddle_y]
    add ax, PADDLE_HEIGHT
    cmp ax, SCREEN_HEIGHT
    ja right_down_done
    mov ax, [right_paddle_y]
    inc ax
    mov [right_paddle_y], ax
right_down_done:
    ret

;--------------------------------------
; Subroutine: update_ball
; Updates ball position and handles collisions with walls and paddles.
; Enhancements:
;   - When colliding with a paddle, adjusts vertical velocity based on impact point.
;   - Increments score on paddle collisions.
;--------------------------------------
update_ball:
    ; Update horizontal position
    mov ax, [ball_x]
    add ax, [ball_dx]
    cmp ax, 0
    jl ball_reset
    cmp ax, SCREEN_WIDTH - BALL_SIZE
    jg ball_reset
    mov [ball_x], ax

    ; Update vertical position
    mov ax, [ball_y]
    add ax, [ball_dy]
    cmp ax, 0
    jl bounce_y
    cmp ax, SCREEN_HEIGHT - BALL_SIZE
    jg bounce_y
    mov [ball_y], ax

    ; Check collision with left paddle
    mov ax, [ball_x]
    cmp ax, LEFT_PADDLE_X + PADDLE_WIDTH
    jg check_right_paddle
    ; Check vertical overlap with left paddle
    mov bx, [left_paddle_y]
    mov cx, [ball_y]
    cmp cx, bx
    jl check_right_paddle
    add bx, PADDLE_HEIGHT
    cmp cx, bx
    jg check_right_paddle
    ; Collision with left paddle detected
    inc word [score]           ; Increment score
    ; Adjust vertical velocity based on impact position:
    ;   Compare ball_y with left paddle center.
    mov ax, [ball_y]
    mov bx, [left_paddle_y]
    add bx, PADDLE_HEIGHT/2
    cmp ax, bx
    jl left_adjust
    je left_adjust_equal
    jg left_adjust2
left_adjust:
    mov word [ball_dy], -1
    jmp left_paddle_collision
left_adjust_equal:
    mov word [ball_dy], -1    ; Slight upward bias to avoid flat trajectory
    jmp left_paddle_collision
left_adjust2:
    mov word [ball_dy], 1
left_paddle_collision:
    mov ax, [ball_dx]
    neg ax
    mov [ball_dx], ax
    jmp update_done

check_right_paddle:
    mov ax, [ball_x]
    cmp ax, RIGHT_PADDLE_X - BALL_SIZE
    jle update_done
    mov bx, [right_paddle_y]
    mov cx, [ball_y]
    cmp cx, bx
    jl update_done
    add bx, PADDLE_HEIGHT
    cmp cx, bx
    jg update_done
    ; Collision with right paddle detected
    inc word [score]
    mov ax, [ball_y]
    mov bx, [right_paddle_y]
    add bx, PADDLE_HEIGHT/2
    cmp ax, bx
    jl right_adjust
    je right_adjust_equal
    jg right_adjust2
right_adjust:
    mov word [ball_dy], -1
    jmp right_paddle_collision
right_adjust_equal:
    mov word [ball_dy], -1
    jmp right_paddle_collision
right_adjust2:
    mov word [ball_dy], 1
right_paddle_collision:
    mov ax, [ball_dx]
    neg ax
    mov [ball_dx], ax

update_done:
    ret

bounce_y:
    ; Bounce off top/bottom walls: reverse vertical direction
    mov ax, [ball_dy]
    neg ax
    mov [ball_dy], ax
    mov ax, [ball_y]
    cmp ax, 0
    jl set_top
    cmp ax, SCREEN_HEIGHT - BALL_SIZE
    jg set_bottom
    jmp update_done

set_top:
    mov ax, 0
    mov [ball_y], ax
    jmp update_done

set_bottom:
    mov ax, SCREEN_HEIGHT - BALL_SIZE
    mov [ball_y], ax
    jmp update_done

ball_reset:
    ; Reset ball to center if it goes off-screen
    mov ax, SCREEN_WIDTH/2
    mov [ball_x], ax
    mov ax, SCREEN_HEIGHT/2
    mov [ball_y], ax
    mov ax, 1
    mov [ball_dx], ax
    mov ax, 1
    mov [ball_dy], ax
    ret

;--------------------------------------
; Subroutine: convert_to_decimal
; Converts AX to a 4-digit decimal string in score_buf.
;--------------------------------------
convert_to_decimal:
    push ax
    push bx
    push dx
    push cx

    ; Thousands digit
    mov cx, 1000
    xor dx, dx
    div cx          ; AX = quotient, DX = remainder
    add al, '0'
    mov [score_buf], al

    ; Hundreds digit
    mov ax, dx
    mov cx, 100
    xor dx, dx
    div cx
    add al, '0'
    mov [score_buf+1], al

    ; Tens digit
    mov ax, dx
    mov cx, 10
    xor dx, dx
    div cx
    add al, '0'
    mov [score_buf+2], al

    ; Ones digit (remainder in DL)
    add dl, '0'
    mov [score_buf+3], dl

    pop cx
    pop dx
    pop bx
    pop ax
    ret

;--------------------------------------
; Subroutine: exit_game
; Exits the game: switches to text mode, displays final score, and waits for a key.
;--------------------------------------
exit_game:
    ; Switch to text mode (mode 3)
    mov ax, 0003h
    int 10h

    ; Display score message and converted score
    mov dx, score_msg
    mov ah, 09h
    int 21h

    mov ax, [score]
    call convert_to_decimal
    mov dx, score_buf
    mov ah, 09h
    int 21h

    ; Wait for a key press before exiting
    mov ah, 0
    int 16h

    mov ax, 4C00h
    int 21h
