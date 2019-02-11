package com.company;

public class Thief implements MailService {
    int packegaPrice;
    int stolenValue;

    Thief(int packegaPrice) {
        this.packegaPrice = packegaPrice;
        this.stolenValue = 0;
    }

    @Override
    public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
            int priceOfPackage = ((MailPackage) mail).getContent().getPrice();
            if (priceOfPackage >= packegaPrice) {
                stolenValue += priceOfPackage;
                return new MailPackage(mail.getFrom(), mail.getTo(), new Package("stones instead of " +
                        ((MailPackage) mail).getContent().getContent(), 0));
            }
        }

        return mail;
    }
    int getStolenValue() {
        return stolenValue;
    }
}
