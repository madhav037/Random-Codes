use std::f32::consts::PI;

struct User {
    name : String,
    age : u32,
    active : bool
}

impl User {
    fn print_age_and_active(&self) {
        print!("age : {}, active : {}", self.age, self.active);
    }
}

enum Shape {
    Circle(f32),
    Square(f32),
    Rec(f32,f32)
}

fn calc_shape_area(shape : Shape) -> f32 {
    let ans  = match shape {
        Shape::Circle(radius) => PI * radius * radius,
        Shape::Rec(width, height ) => width * height,
        Shape::Square(len) => len * len 
    };
    ans
}

fn main() {
    let x : i8 = -7;
    let y : u8 = 7;
    let z : f32 = 10.02;
    println!("X : {}, Y : {}, Z : {}",x,y,z);

    let is_true : bool = true;
    if is_true {
        print!("yes\n");
    }else {
        print!("no");
    }

    let text: String = String::from("HELLo");
    print!("{}\n",text);

    let ch = text.chars().nth(0);

    match ch {
        Some(c) => print!("{}\n",c),
        None => print!("error")
    }

    for i in 0..10 {
        print!("{}\n", i);
    }

    let word = String::from("Hellloooo this is a string!!");
    let first_word = get_first_word(word);
    print!("{}\n", first_word);

    let mut s1 = String::from("Hello this is a string");
    let s2 = &mut s1;
    s2.push_str("string");

    let user = User {
        name: String::from("name"),
        age: 30,
        active : true
    };
    println!("{}\n",user.name);
    user.print_age_and_active();

    let circle = Shape::Circle(20.02);
    print!("{}\n",calc_shape_area(circle));
}


fn get_first_word(str : String) -> String {
    let mut ans = String::from("");
    for ch in str.chars() {
        ans.push(ch);
        if ch == ' ' {
            break;
        }
    }
    ans
}

// https://projects.100xdevs.com/tracks/rust-bootcamp/Rust-Bootcamp-1