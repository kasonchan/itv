package checkout

import checkout.Checkout._
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by kasonchan on 1/26/16.
  */
class CheckoutSpecs extends FlatSpec with Matchers {

  val A = SKU('A', 50, Map(3 -> 130, 5 -> 200))
  val B = SKU('B', 30, Map(2 -> 45))
  val C = SKU('C', 20)
  val D = SKU('D', 15)

  val emptyBasket = Basket()
  val basket1 = Basket(List(A, B, C, B))
  val basket2 = Basket(List(A, A, A, A, B, B, B, C, D))
  val basket3 = Basket(List(A, A, A, A, A, B, B, B, C, D))
  val basket4 = Basket(List(D, B, A, B, C, C, A, A))
  val basket5 = Basket(List(D, D, D, D, D))

  "countItems" should "pass" in {
    countItems(emptyBasket, 'A') shouldBe 0
    countItems(emptyBasket, 'B') shouldBe 0
    countItems(emptyBasket, 'C') shouldBe 0
    countItems(emptyBasket, 'D') shouldBe 0
    countItems(emptyBasket, 'E') shouldBe 0
    countItems(basket1, 'A') shouldBe 1
    countItems(basket1, 'B') shouldBe 2
    countItems(basket1, 'C') shouldBe 1
    countItems(basket1, 'D') shouldBe 0
    countItems(basket1, 'E') shouldBe 0
    countItems(basket2, 'A') shouldBe 4
    countItems(basket2, 'B') shouldBe 3
    countItems(basket2, 'C') shouldBe 1
    countItems(basket2, 'D') shouldBe 1
    countItems(basket2, 'E') shouldBe 0
    countItems(basket3, 'A') shouldBe 5
    countItems(basket3, 'B') shouldBe 3
    countItems(basket3, 'C') shouldBe 1
    countItems(basket3, 'D') shouldBe 1
    countItems(basket3, 'E') shouldBe 0
    countItems(basket4, 'A') shouldBe 3
    countItems(basket4, 'B') shouldBe 2
    countItems(basket4, 'C') shouldBe 2
    countItems(basket4, 'D') shouldBe 1
    countItems(basket4, 'E') shouldBe 0
  }

  "getQuotientRemainder" should "pass" in {
    getQuotientRemainder(6, 5) shouldBe(1, 1)
    getQuotientRemainder(5, 5) shouldBe(1, 0)
    getQuotientRemainder(4, 5) shouldBe(0, 4)
    getQuotientRemainder(3, 5) shouldBe(0, 3)
    getQuotientRemainder(2, 5) shouldBe(0, 2)

    getQuotientRemainder(5, 2) shouldBe(2, 1)
    getQuotientRemainder(4, 2) shouldBe(2, 0)
    getQuotientRemainder(3, 2) shouldBe(1, 1)
    getQuotientRemainder(2, 2) shouldBe(1, 0)

    getQuotientRemainder(7, 3) shouldBe(2, 1)
    getQuotientRemainder(6, 3) shouldBe(2, 0)
    getQuotientRemainder(5, 3) shouldBe(1, 2)
    getQuotientRemainder(4, 3) shouldBe(1, 1)
    getQuotientRemainder(3, 3) shouldBe(1, 0)
    getQuotientRemainder(2, 3) shouldBe(0, 2)
    getQuotientRemainder(1, 3) shouldBe(0, 1)
  }

  "getBestUnit" should "pass" in {
    getBestUnit(Map(), 1) shouldBe 1
    getBestUnit(Map(), 2) shouldBe 2
    getBestUnit(Map(3 -> 130, 5 -> 200), 1) shouldBe 1
    getBestUnit(Map(3 -> 130, 5 -> 200), 2) shouldBe 2
    getBestUnit(Map(3 -> 130, 5 -> 200), 3) shouldBe 3
    getBestUnit(Map(3 -> 130, 5 -> 200), 4) shouldBe 3
    getBestUnit(Map(3 -> 130, 5 -> 200), 5) shouldBe 5
    getBestUnit(Map(3 -> 130, 5 -> 200), 6) shouldBe 5
    getBestUnit(Map(3 -> 130, 5 -> 200), 6) shouldBe 5
    getBestUnit(Map(3 -> 130, 5 -> 200), 7) shouldBe 5
  }

  "basket1" should "pass" in {
    getTotalPrice(basket1) shouldBe 115
  }

  "basket2" should "pass" in {
    getTotalPrice(basket2) shouldBe 290
  }

  "basket3" should "pass" in {
    getTotalPrice(basket3) shouldBe 310
  }

  "basket4" should "pass" in {
    getTotalPrice(basket4) shouldBe 230
  }

  "basket5" should "pass" in {
    getTotalPrice(basket5) shouldBe 75
  }

}
