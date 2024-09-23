/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Strategy;

/**
 *
 * @author ranee
 */
public class HardStrategy implements IStrategy {


    @Override
    public int getTimeout() {
        return 1;
    }

    @Override
    public int getPlates() {
        return 5;
    }

}
