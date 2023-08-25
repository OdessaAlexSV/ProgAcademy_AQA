package org.prog.classwork;

public class Journey {
  public String from;
  public String destination;
  public String passingThrough;

  @Override
  public boolean equals(Object o) {
    if (o instanceof Journey) {
      Journey j = (Journey) o;
      return this.destination.equals(j.destination)
          && this.from.equals(j.from)
          && this.passingThrough.equals(j.passingThrough);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return (from + passingThrough + destination).hashCode();
  }

  @Override
  public String toString() {
    return "journey from " + from + " to " + destination + " through " + passingThrough;
  }
}