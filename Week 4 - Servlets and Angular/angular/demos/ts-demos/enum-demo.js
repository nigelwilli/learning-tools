var OtherEnum;
(function (OtherEnum) {
    OtherEnum[OtherEnum["THING_1"] = 1] = "THING_1";
    OtherEnum[OtherEnum["THING_2"] = 2] = "THING_2";
})(OtherEnum || (OtherEnum = {}));
var Colors;
(function (Colors) {
    Colors[Colors["RED"] = 0] = "RED";
    Colors[Colors["GREEN"] = 1] = "GREEN";
    Colors[Colors["BLUE"] = 2] = "BLUE";
})(Colors || (Colors = {}));
var background = Colors.RED;
console.log(background);
