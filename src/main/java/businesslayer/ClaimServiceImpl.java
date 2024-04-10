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
        // Perform any necessary validation or business logic
        claimDao.save(claim);
    }
  
}

