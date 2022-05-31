var questions = [
    {
          prompt: "How long are your showers usually?\n(a) 10 mins\n\ (b) 20 mins\n(c) 30 mins or more",
          answer: "a"
    },
    {
         prompt: "Around how often do you fill up for gas?\n(a) once a week\n\ (b) once every 2 weeks\n\ (c) 1-2 times a month",
         answer: "c"
    },
    {
         prompt: "When you brush your teeth do you keep your sink running?\n(a) Yes\n\ (b) No\n(c) sometimes",
         answer: "b"
    }
];
var score = 0;

for(var i = 0; i < questions.length; i++){
    var response = window.prompt(questions[i].prompt);
    if(response == questions[i].answer){
         score++;
         alert("good job!");
    } else {
         alert("the environment is hurting!");
    }
}
alert("Thank you for taking our survey, you got " + score + "/" + questions.length + "of the most optimal answers for the environment. Your score has been logged");