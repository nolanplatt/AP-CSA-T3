console.log("called->")
var app = document.getElementById('app');

var typewriter = new Typewriter(app, {
    loop: true
});

typewriter.typeString
('a world where ...')
    .typeString(' <strong> there is a surplus of trees</strong>')
    .pauseFor(2500)
    .deleteChars(45)
    .typeString('<strong> our planet is a stable temperature</strong>')
    .pauseFor(2500)
    .deleteChars(52)
    .typeString('<strong> pollution is no longer a threat</strong>')
    .start();