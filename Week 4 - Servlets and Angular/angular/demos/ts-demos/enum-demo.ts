enum OtherEnum {
    THING_1 = 1,
    THING_2 = 2
}

enum Colors {
    RED =0,
    GREEN = OtherEnum.THING_1,
    BLUE = 2
}

let background = Colors.RED;
console.log(background);