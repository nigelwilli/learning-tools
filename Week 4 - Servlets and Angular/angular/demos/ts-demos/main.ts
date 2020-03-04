function log(message: string): void {
    console.log(message);
}

let message = 'Hello, TypeScript!';

log(message);

function doSomething() {
    for(let i = 0; i < 5; i++) {
        console.log(i);
    }
    console.log('Finally: ' + i);
}