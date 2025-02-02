package States;

import VendingMachine.VendingMachine;
import VendingMachine.Coin;
import VendingMachine.Item;

import java.util.List;

public interface State {
    public void clickInsertCoinBtn(VendingMachine vendingMachine) throws Exception;

    public void clickProductSelectionBtn(VendingMachine vendingMachine) throws Exception;

    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception;

    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception;

    public int getChange(int returnChangeMoney) throws Exception;

    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception;

    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception;

    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception;
}
