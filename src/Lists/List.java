/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Lists;

/**
 *
 * @author unknown
 */
public interface List <L> {
    public boolean add(L l);
    
    public boolean remove(L l);
    
    public L find(Object id);
    
    public void showAll();
}
