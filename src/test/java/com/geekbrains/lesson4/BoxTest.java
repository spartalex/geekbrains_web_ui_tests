package com.geekbrains.lesson4;

import org.junit.jupiter.api.*;


import static org.assertj.core.api.Assertions.*;

public class BoxTest {
    Box box;

    @Nested
    class WhenIsEmpty {
        @BeforeEach
        void createBox() {
            box = new Box();
        }

        @Test
        void addBallTest() {
            box.addBall();
            Assertions.assertEquals(1, box.getBallsCounter());
        }

        @Test
        void removeBallFromEmptyBoxTest() {
            assertThatNullPointerException().isThrownBy(() -> box.removeBall());
        }

        @Test
        void shuffleEmptyBoxTest() {
            assertThatExceptionOfType(BoxIsEmptyException.class).isThrownBy(() -> box.shuffleBalls());
        }

        @Nested
        class WhenWithBals {
            @BeforeEach
            void addBalls() {
                box.addBall();
            }

            @Test
            void removeBallFromBoxWithBalls() {
                box.removeBall();
                assertThat(box.getBallsCounter()).isEqualTo(0);
            }
        }
    }

}
