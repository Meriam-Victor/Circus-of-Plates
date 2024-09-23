/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Strategy;

public class MediumStrategy implements IStrategy {

//    @Override
//    public int getSpeed() {
//        return 2;
//    }

    @Override
    public int getTimeout() {
        return 2;
    }

    @Override
    public int getPlates() {
        return 10;
    }

}
