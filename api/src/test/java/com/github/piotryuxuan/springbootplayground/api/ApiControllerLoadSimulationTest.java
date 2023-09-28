package com.github.piotryuxuan.springbootplayground.api;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

import java.util.Random;

public class ApiControllerLoadSimulationTest extends Simulation {

	HttpProtocolBuilder httpProtocol = http.baseUrl("http://localhost:8080");
	Random randomGenerator = new Random();

	ScenarioBuilder scn = scenario("BasicSimulation")
			.exec(http("request_addition").get("/api/v1/addition")
					.queryParam("a", String.valueOf(randomGenerator.nextLong()))
					.queryParam("b", String.valueOf(randomGenerator.nextLong())));

	{
		setUp(
				scn.injectOpen(
						atOnceUsers(100),
						constantUsersPerSec(100).during(30),
						rampUsers(1_500).during(60),
						constantUsersPerSec(1_500).during(10)).protocols(httpProtocol));
	}
}
