package com.dot2line.empirestate

import io.kotest.core.spec.style.BehaviorSpec

class MainTest : BehaviorSpec({
    Given("?") {
        val viewModel = MainViewModel()
        When("Button 클릭 했을 때") {
            viewModel.process(MainViewEvent.ClickButton)
            Then("데이터가 표시되어야 한다.") {
                viewModel.state.value
            }
        }
    }
})
