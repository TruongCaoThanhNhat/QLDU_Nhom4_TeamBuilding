indexQuestion = 0;
isClicked = false;
countCorrect = 0
totalTime = document.getElementById("total-time");
time = 0;
setInterval(() => {
    totalTime.innerText = time++
}, 1000);

timeDownElement = document.getElementById('time-down');
// function timeDown(durationInSeconds) {
//     initialWidth = 100; // Độ rộng ban đầu, có thể thay đổi tùy ý
//     countdownInterval = setInterval(function () {
//         initialWidth -= (100 / durationInSeconds);
//         timeDownElement.style.width = initialWidth + '%';
//         if (initialWidth <= 0) {
//             clearInterval(timeDown);
//         }
//     }, 1000);
// }
var countdownInterval

function startCountdownWithDelay(durationInSeconds) {
    countdownElement = document.getElementById('time-down');
    initialWidth = 100;

    // Delay trước khi bắt đầu đếm ngược
    setTimeout(function () {
        countdownInterval = setInterval(function () {
            initialWidth -= (100 / durationInSeconds);
            countdownElement.style.width = initialWidth + '%';
            if (initialWidth <= 0) {
                clearInterval(countdownInterval);
            }
        }, 1000); // Cập nhật mỗi giây
    }, 1000); // Chuyển đổi giây thành milliseconds
}

// startCountdownWithDelay(20)

function stopCountdown(countdownInterval) {

    clearInterval(countdownInterval);
}

function checkAnswer(button) {
    // stopCountdown(countdownInterval)
    // startCountdownWithDelay(60, 5);
    if (!isClicked) {
        isClicked = true;
        if (button.classList.contains("true")) {
            button.classList.add("bg-green");
            setTimeout(() => {
                document.getElementsByClassName("congratulation")[0].classList.remove("d-none");
                document.getElementsByClassName("button-continue")[0].classList.remove("d-none");
            }, 300);
            countCorrect++
        } else {
            button.classList.add("bg-red");
            setTimeout(() => {
                document.getElementsByClassName("regret")[0].classList.remove("d-none");
                document.getElementsByClassName("button-continue")[0].classList.remove("d-none");
            }, 300);
        }
    }
}



key = document.getElementById("key").innerText
console.log(key)


function clickNext() {
    // startCountdownWithDelay(20)
    // resetCountdown()
    total = totalTime.innerText
    indexQuestion++;
    $.ajax({
        url: "/NextQuestion",
        type: "get", //send it through get method
        data: {
            indexQuestion: indexQuestion,
            countCorrect: countCorrect,
            key: key,
            totalTime: total
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