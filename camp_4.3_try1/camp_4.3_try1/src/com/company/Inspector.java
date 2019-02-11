package com.company;

public class Inspector implements MailService {

    public final static String WEAPONS = "weapons";
    public final static String BANNED_SUBSTANCE = "banned substance";

    public class IllegalPackageException extends RuntimeException {

        public IllegalPackageException (String message) {
            super(message);
        }

    }

    public class StolenPackageException extends RuntimeException{

        public StolenPackageException (String message) {
            super(message);
        }

    }

    @Override
    public Sendable processMail(Sendable mail) {

        if (mail instanceof MailPackage) {
            String contentOfPackage = ((MailPackage) mail).getContent().getContent();
            if (contentOfPackage.contains("stones")) {
                throw new StolenPackageException("Discovered the theft from the parcel!");
            } else if (contentOfPackage.contains(WEAPONS) | contentOfPackage.contains(BANNED_SUBSTANCE)) {
                throw new IllegalPackageException("In the package discovered forbidden content.");
            }
        }
        return mail;
    }
}