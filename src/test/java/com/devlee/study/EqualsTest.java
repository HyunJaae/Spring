package com.devlee.study;

import com.devlee.study.model.Point;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class EqualsTest {

    @Test
    void equals() {
        Point point = new Point(2, 3);
        Point point2 = new Point(2, 3);

        // point != point2
        assertThat(point == point2).isFalse();  // 동일성 비교
    }
}


