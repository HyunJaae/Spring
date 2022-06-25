package com.devlee.study.designpattern.decorator;

import com.devlee.study.designpattern.decorator.solution.CrossingDecorator;
import com.devlee.study.designpattern.decorator.solution.Display;
import com.devlee.study.designpattern.decorator.solution.LaneDecorator;
import com.devlee.study.designpattern.decorator.solution.TrafficDecorator;

public class Client {
    public static void main(String[] args) {
        Display road = new RoadDisplay();
        road.draw(); // 기본 도로 표시
        RoadDisplay roadDisplayWithLane = new RoadDisplayWithLane();
        roadDisplayWithLane.draw(); // 기본 도로 표시 + 차선 표시

        // Client 는 Display 클래스만을 통해 도로 정보를 표시할 수 있다.
        Display roadWithLane = new LaneDecorator(new RoadDisplay());
        roadWithLane.draw(); // 기본 도로 표시 + 차선 표시
        Display roadWithTraffic = new TrafficDecorator(new RoadDisplay());
        roadWithTraffic.draw(); // 기본 도로 표시 + 교통량 표시

        // 기본 도로 표시 + 차선 표시 + 교통량 표시
        Display roadWithLaneAndTraffic =
                new TrafficDecorator(
                        new LaneDecorator(
                                new RoadDisplay()));
        roadWithLaneAndTraffic.draw();

        // 기본 도로 표시 + 차선 표시 + 교통량 표시 + 교차로 표시
        Display roadWithCrossingLaneAndTraffic =
                new LaneDecorator(
                        new TrafficDecorator(
                                new CrossingDecorator(
                                        new RoadDisplay())));
        roadWithCrossingLaneAndTraffic.draw();
    }
}
