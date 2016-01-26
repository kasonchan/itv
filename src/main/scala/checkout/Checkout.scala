package checkout

/**
  * Created by kasonchan on 1/26/16.
  */
/**
  * Stock keeping unit
  *
  * @param item         item
  * @param unitPrice    unit price
  * @param specialPrice special price
  */
case class SKU(item: Char,
               unitPrice: Int,
               specialPrice: Map[Int, Int] = Map())

/**
  * Basket
  *
  * @param items list of items to be purchased
  */
case class Basket(items: List[SKU] = List())

object Checkout {

  /**
    * Counts the number of target item in the basket.
    *
    * @param basket basket of items to be counted
    * @param t      target item
    */
  def countItems(basket: Basket, t: Char): Int = {
    basket.items.count(i => i.item == t)
  }

  /**
    * Get the quotient and remainder.
    *
    * @param x dividend
    * @param y divisor
    */
  def getQuotientRemainder(x: Int, y: Int): (Int, Int) = {
    (x / y, x % y)
  }

  /**
    * Returns the best unit of special prices.
    *
    * @param list list of special prices
    * @param x    number of items to be bought
    */
  def getBestUnit(list: Map[Int, Int], x: Int): Int = {
    list.takeWhile(_._1 <= x).lastOption.getOrElse((x, x))._1
  }

  /**
    * Return the total price of the basket.
    *
    * @param basket basket to be checked out
    */
  def getTotalPrice(basket: Basket): Int = {
    val uniqueItems: List[SKU] = basket.items.distinct

    val uniqueItemsCounts = for (i <- uniqueItems) yield (i.item, countItems(basket, i.item))

    val totalList = for {
      s@SKU(uii, uiup, uisp) <- uniqueItems
      (i, count) <- uniqueItemsCounts
      if uii == i
    } yield (s, count)

    totalList.map {
      case (sku@SKU(i, up, sp), count) =>
        val bestUnitsOffer: Int = getBestUnit(sp, count)
        sku.specialPrice.get(bestUnitsOffer) match {
          case Some(bestValue) =>
            val (bestUnits: Int, remainder: Int) = getQuotientRemainder(count, bestUnitsOffer)
            (bestUnits * bestValue) + (remainder * up)
          case None =>
            count * up
        }
      case _ => 0
    }.sum
  }

}
