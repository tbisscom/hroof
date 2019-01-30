package com.tbiss.hroof.service.v1.user.competitor;

import com.tbiss.hroof.api.v1.model.user.CompetitorPatchDTO;
import com.tbiss.hroof.domain.user.User;

public interface CompetitorService {

    String update(User userDetails , CompetitorPatchDTO competitorPatchDTO);
}
