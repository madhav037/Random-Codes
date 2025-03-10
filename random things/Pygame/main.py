import pygame
import sys
import random

# Initialize Pygame
pygame.init()

# Set up the game window
width, height = 600, 400
screen = pygame.display.set_mode((width, height))
pygame.display.set_caption("Catch the Ball")

# Set up colors
white = (255, 255, 255)
black = (0, 0, 0)
red = (255, 0, 0)

# Set up the player paddle
paddle_width, paddle_height = 100, 20
paddle_x = (width - paddle_width) // 2
paddle_y = height - 2 * paddle_height
paddle_speed = 8

# Set up the ball
ball_radius = 20
ball_x = random.randint(ball_radius, width - ball_radius)
ball_y = 0
ball_speed = 5

#points
points = 0

# Game loop
clock = pygame.time.Clock()

while True:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()

    # Move the paddle with arrow keys
    keys = pygame.key.get_pressed()
    if keys[pygame.K_LEFT] and paddle_x > 0:
        paddle_x -= paddle_speed
    if keys[pygame.K_RIGHT] and paddle_x < width - paddle_width:
        paddle_x += paddle_speed

    # Move the ball
    ball_y += ball_speed

    # Check for collisions with the paddle
    if (
        paddle_x - ball_radius < ball_x < paddle_x + paddle_width + ball_radius
        and paddle_y - ball_radius < ball_y < paddle_y + paddle_height
    ):
        # Ball caught, reset its position
        ball_x = random.randint(ball_radius, width - ball_radius)
        ball_y = 0
        points += 1

    # Check if the ball is out of bounds
    if ball_y > height:
        # Ball missed, reset its position
        ball_x = random.randint(ball_radius, width - ball_radius)
        ball_y = 0
        points = 0
        # ball_speed = 5
        # paddle_speed = 8
        # paddle_width = 100

    # if (points % 5 == 0) and (points != 0):
    #     ball_speed += 0.2
    #     paddle_speed += 0.3
    #     paddle_width += 5

    # Draw the background
    screen.fill(black)

    # Draw the paddle
    pygame.draw.rect(screen, white, (paddle_x, paddle_y, paddle_width, paddle_height))

    # Draw the ball
    pygame.draw.circle(screen, red, (ball_x, int(ball_y)), ball_radius)
    
    #Draw the points
    font = pygame.font.Font(None, 36)
    text = font.render(f"Points: {points}", True, white)
    screen.blit(text, (10, 10))
    

    # Update the display
    pygame.display.flip()

    # Cap the frame rate
    clock.tick(60)
