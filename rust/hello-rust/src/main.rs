mod other_file;
mod password_encryptor;
use rand::Rng;
use std::cmp::Ordering;
use std::io;

fn main() {
    // guess_the_number();
    // other_file::hello();
    password_encryptor::password_encryptor();
    // password_generator();
}

fn password_generator() {
    let numbers: [i32; 10] = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
    let chars: [char; 26] = [
        'z', 'x', 'c', 'v', 'b', 'n', 'm', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'q', 'w',
        'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'
    ];
    let symbols: [char; 14] = [
        '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '+', '-', '/',
    ];

    print!("Random password generator");

    println!("Enter strength of the password between 1-5 : ");
    let mut strength = String::new();

    io::stdin().read_line(&mut strength).expect("Fail to read");

    let strength = match strength.trim().parse::<i32>() {
        Ok(num) => {
            if (1..=5).contains(&num) {       
                num
            } else {
                println!("Number not between given range");
                return;
            }
        }
        Err(_) => {
            println!("Invalid input. Please enter a valid integer.");
            return;
        }
    };

    let mut password = String::new();
    match strength {
        1 => {
            let mut i = 0;
            while i <= 8 {
                let index = rand::thread_rng().gen_range(0..=numbers.len()-1);
                password += &numbers[index].to_string();
                i += 1;
            }
        },
        2 => {
            let mut i = 0;
            while i <= 8 {
                let index = rand::thread_rng().gen_range(0..=chars.len()-1);
                password += &chars[index].to_string();
                i += 1;
            }
        },
        3 => {
            let mut i = 0;
            while i <= 12 {
                let arr = rand::thread_rng().gen_range(1..=2);
                if arr == 1 {
                    let index = rand::thread_rng().gen_range(0..=numbers.len()-1);
                    password += &numbers[index].to_string();
                }else {
                    let index = rand::thread_rng().gen_range(0..=chars.len()-1);
                    password += &chars[index].to_string();
                }
                i += 1;
            }
        },
        4 => {
            let mut i = 0;
            while i <= 12 {
                let arr = rand::thread_rng().gen_range(1..=2);
                if arr == 1 {
                    let index = rand::thread_rng().gen_range(0..=numbers.len()-1);
                    password += &numbers[index].to_string();
                }else {
                    let index = rand::thread_rng().gen_range(0..=chars.len()-1);
                    if i % 2 == 0 {
                        password += &chars[index].to_string().to_uppercase();
                    }else {
                        password += &chars[index].to_string();
                    }
                }
                i += 1;
            }
        },
        5 => {
            let mut i = 0;
            while i <= 12 {
                let arr = rand::thread_rng().gen_range(1..=3);
                if arr == 1 {
                    let index = rand::thread_rng().gen_range(0..=numbers.len()-1);
                    password += &numbers[index].to_string();
                }else if arr == 2{
                    let index = rand::thread_rng().gen_range(0..=chars.len()-1);
                    if i % 2 == 0 {
                        password += &chars[index].to_string().to_uppercase();
                    }else {
                        password += &chars[index].to_string();
                    }
                }else {
                    let index = rand::thread_rng().gen_range(0..=symbols.len()-1);
                    password += &symbols[index].to_string();
                }
                i += 1;
            }
        },
        _ => {
            print!("hmm... something went wrong");
        }
    }
    println!("{password}");
}

fn guess_the_number() {
    println!("Guess the number!");

    let secret_number = rand::thread_rng().gen_range(1..=100);

    loop {
        print!("Please guess number : ");

        let mut guess = String::new();

        io::stdin()
            .read_line(&mut guess)
            .expect("Fail to read number");

        let guess: u32 = match guess.trim().parse() {
            Ok(num) => num,
            Err(_) => continue,
        };

        println!("You have guessed {guess}");

        match guess.cmp(&secret_number) {
            Ordering::Less => println!("Too small!"),
            Ordering::Greater => println!("Too large!"),
            Ordering::Equal => {
                println!("YOU WIN!!");
                break;
            }
        }
    }
}
