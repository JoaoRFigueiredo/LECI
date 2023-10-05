package startypes;

import startypes.*;

public enum StarTypeEnum {
  O(new OStar()), B(new BStar()), A(new AStar()), F(new FStar()), G(new GStar()), K(new KStar()), M(new MStar());

  private StarType body;

  private StarTypeEnum(StarType star) {
    this.body = star;
  }

  public StarType getStarBody() {
    return this.body;
  }
}
