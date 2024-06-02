package myApp.myDomain;

import java.math.BigDecimal;
import java.util.Objects;

public class Game {

    private Long id;
    private String title;
    private BigDecimal basePrice;

    private int dlcNumber;

    private BigDecimal fullPrice;

    private String article;

    public Game(Long id, String title, BigDecimal basePrice, int dlcNumber) {
        this.id = id;
        this.title = title;
        this.basePrice = basePrice;
        this.dlcNumber = dlcNumber;
        BigDecimal dlcPrice = this.basePrice.divide(new BigDecimal(4));
        this.fullPrice = this.basePrice.add(dlcPrice.multiply(new BigDecimal(this.dlcNumber)));
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public int getDlcNumber() {
        return dlcNumber;
    }

    public void setDlcNumber(int dlcNumber) {
        this.dlcNumber = dlcNumber;
        BigDecimal dlcPrice = this.basePrice.divide(new BigDecimal(4));
        this.fullPrice = this.basePrice.add(dlcPrice.multiply(new BigDecimal(this.dlcNumber)));
    }

    public BigDecimal getFullPrice() {
        return fullPrice;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return dlcNumber == game.dlcNumber && Objects.equals(id, game.id) && Objects.equals(title, game.title) && Objects.equals(basePrice, game.basePrice) && Objects.equals(fullPrice, game.fullPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, basePrice, dlcNumber, fullPrice);
    }

    @Override
    public String toString() {
        return String.format("Game: id - %d, title - %s, basePrice - %s, dlcNumber - %s, fullPrice ´- %s", id, title, basePrice, dlcNumber,fullPrice);
    }
}

