import io.gatling.core.Predef._
import io.gatling.http.Predef._

class BenchSimulation extends Simulation {

  private val baseUrl = "http://localhost:8080"
  private val endpoint = "/users"
  private val contentType = "application/json"
  private val requestCount = 4

  private val simUsers = System.getProperty("SIM_USERS", "1").toInt

  private val httpConf = http
    .baseUrl(baseUrl)
    .acceptHeader("application/json;charset=UTF-8")

  private val addUserTest = repeat(requestCount) {
    exec(http("add-user-test")
      .post(endpoint)
      .header("Content-Type", contentType)
      .body(StringBody(
        s"""
           | {
           |  "firstName": "test-firstName",
           |  "lastName": "test-lastName"
           | }
         """.stripMargin
      )).check(status.is(201)))
  }
  private val scn = scenario("BenchSimulation")
    .exec(addUserTest)

  setUp(scn.inject(atOnceUsers(simUsers))).protocols(httpConf)
}