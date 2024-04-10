package businesslayer;

import dataaccesslayer.ClaimDao;
import model.Claim;

public class ClaimServiceImpl implements ClaimService {
    private ClaimDao claimDao;

    public ClaimServiceImpl(ClaimDao claimDao) {
        this.claimDao = claimDao;
    }

    @Override
    public void submitClaim(Claim claim) {
       
        claimDao.save(claim);
    }
  
}

