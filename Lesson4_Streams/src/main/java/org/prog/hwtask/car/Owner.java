package org.prog.hwtask.car;

public class Owner {

  public String name;
  public String lastName;
  public String homeRegister;

  @Override
  public boolean equals(Object o) {
    if (o instanceof Owner) {
      Owner owner = (Owner) o;
      return owner.name.equals(this.name) && owner.lastName.equals(this.lastName);
//                    && owner.homeRegister.equals(this.homeRegister);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return (name + lastName).hashCode();
  }


  @Override
  public String toString() {
    return name +" "+ lastName;
  }



}
