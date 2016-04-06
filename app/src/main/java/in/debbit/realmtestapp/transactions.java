package in.debbit.realmtestapp;

/**
 * Created by chirag on 6/4/16.
 */
public class transactions {

    private String merchant;
    private String category;
    private String amount;
    private int iconid;
    private String timestamp;
    private String sharedwith;

    public transactions (String merchant, String category, String amount, int iconid, String timestamp, String sharedwith){
        super();
        this.merchant = merchant;
        this.category = category;
        this.amount = amount;
        this.iconid = iconid;
        this.timestamp = timestamp;
        this.sharedwith = sharedwith;
    }

    public String getMerchant() {
        return merchant;
    }

    public String getCategory() {
        return category;
    }

    public String getAmount() {
        return amount;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getSharedwith() {
        return sharedwith;
    }

    public int getIconid() {
        return iconid;
    }
}
