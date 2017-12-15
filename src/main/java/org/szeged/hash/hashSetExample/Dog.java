package org.szeged.hash.hashSetExample;

class Dog{
    String color;

    public Dog(String s){
        color = s;
    }

    //overridden method, has to be exactly the same like the following
    public boolean equals(Object obj) {
        if (!(obj instanceof Dog))
            return false;
        if (obj == this)
            return true;
        return this.color.equals(((Dog) obj).color);
    }

    public int hashCode(){
        return color.length();//for simplicity reason
    }
}
