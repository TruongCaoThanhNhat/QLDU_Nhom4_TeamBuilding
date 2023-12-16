indexQuestion = 0;
isClicked = false;
const totalTime = document.getElementById("total-time");
time = 0;
setInterval(() => {
    totalTime.innerText = time++
}, 1000);

function checkAnswer(button) {
    if (!isClicked) {
        isClicked = true;
        if (button.classList.contains("true")) {
            button.classList.add("bg-green");
            setTimeout(() => {
                document.getElementsByClassName("congratulation")[0].classList.remove("d-none");
                document.getElementsByClassName("button-continue")[0].classList.remove("d-none");
            }, 300);
        } else {
            button.classList.add("bg-red");
            setTimeout(() => {
                document.getElementsByClassName("regret")[0].classList.remove("d-none");
                document.getElementsByClassName("button-continue")[0].classList.remove("d-none");
            }, 300);
        }
    }
}

function nextQuestion() {
    indexQuestion++;
    $.ajax({
        url: "/NextQuestion",
        type: "get", //send it through get method
        data: {
            indexQuestion: indexQuestion
        },
        success: function (response) {
            console.log(response.answer1)
            // console.log(response)
            $(".question").text(response.question);
            $(".answer-item-1").text(response.answer1);
            $(".answer-item-2").text(response.answer2);
            $(".answer-item-3").text(response.answer3);
            $(".answer-item-4").text(response.answer4);
            deleteCorrect();
            $(".answer-item").addClass("false");
            $(".answer-item-" + response.correctAnswer).removeClass("false").addClass("true");
            $(".answer-item").removeClass("bg-red bg-green");
            $(".index-question").text(indexQuestion + 1);
            isClicked = false;
            // $(".answer-item-" + response.correctAnswer).classList.add("true");

        },
        error: function (xhr) {
            //Do Something to handle error
        }
    });
}

function deleteCorrect() {
    const answers = document.getElementsByClassName("answer-item");
    for (let i = 0; i < answers.length; i++) {
        answers[i].classList.remove("true");
        answers[i].classList.remove("false");
        // answers[i].removeClass("false");
    }
}