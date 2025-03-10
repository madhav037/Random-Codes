use std::io::{self, Write};
use rand::Rng;

pub fn password_encryptor() {
    
    print!("Enter password : ");
    io::stdout().flush().expect("Failed to flush stdout");
    let mut password = String::new();
    io::stdin().read_line(&mut password).expect("Failed to read password");

    let length_of_password = password.len();

    print!("Enter key for encrypting (2-8 numbers) : ");
    io::stdout().flush().expect("Failed to flush stdout");

    let mut key = String::new();
    io::stdin().read_line(&mut key).expect("Failed to read key");
    
    let length_of_key: usize = key.len();
    let key:i32 = key.trim().parse().expect("Key error");

    print!("Remember you key : {}",key);
    let mut i = 0;
    let enc_data:[char;50] = ['z', 'x', 'c', 'v', 'b', 'n', 'm', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'q', 'w',
    'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '+', '-', '/', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'];
    let mut encrypted_password = password.clone();

    while i < length_of_key || i < length_of_password {
        let letter = rand::thread_rng().gen_range(0..=length_of_password-1);
        let rep_letter = enc_data[rand::thread_rng().gen_range(0..=49)].to_string();
        encrypted_password.replace_range(letter..letter+1, &rep_letter);
        i += 1;
    }

    print!("your password is : {}",encrypted_password);
}