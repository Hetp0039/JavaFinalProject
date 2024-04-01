package controller;
import java.util.List;

import dataaccesslayer.ClaimDao;
import model.Claim;

public class ClaimController {
    private final ClaimDao claimDao;

    public ClaimController(ClaimDao claimDao) {
        this.claimDao = claimDao;
    }

    public void submitClaim(Claim claim) {
        claimDao.save(claim);
    }

    public List<Claim> getAllClaims() {
        return claimDao.getAllClaims();
    }
}
