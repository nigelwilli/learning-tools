let drawPoint = (x, y) => {
    // implemention here
}

let drawPoint_2 = (point) => {
    // impl goes here.
}

drawPoint_2({
    x: 1,
    y: 2
});

let drawPoint_3 = (point: {x: number, y: number}) => {
    //...
}

drawPoint_3({
    a: 1,
    b: 4
})

interface Point {
    x: number,
    y: number
}

let drawPoint_4 = (point: Point) => {

}

drawPoint_4({
    x: 1,
    y: 4
});
