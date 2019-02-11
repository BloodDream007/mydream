package com.company;

public class UntrustworthyMailWorker implements MailService{
    public final MailService unrealMailServices[];
    public final RealMailService realMailService;


    public UntrustworthyMailWorker(MailService unrealMailServices[]) {

        this.unrealMailServices = unrealMailServices;
        realMailService = new RealMailService();
    }

        public RealMailService getRealMailService() {

            return realMailService;

        }

    @Override
    public Sendable processMail(Sendable mail) {
        for (MailService unrealMailService : unrealMailServices) {
            mail = unrealMailService.processMail(mail);
        }
        return realMailService.processMail(mail);
    }
}
