/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package endpointalice;

/**
 *
 * @author JasonatUSF
 */
public interface IDESRound {
     /** This function should carry out a single round of DES using
        the provided data and subkey for that round. */
    public byte[/*8*/] doOneRound( byte[/*8*/] data, byte[/*6*/] key );
}
