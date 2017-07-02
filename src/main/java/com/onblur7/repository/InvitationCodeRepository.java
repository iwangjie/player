package com.onblur7.repository;

import com.onblur7.entity.InvitationCode;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by ronger on 2017/7/2.
 */
public interface InvitationCodeRepository  extends PagingAndSortingRepository<InvitationCode,Integer> {

    /**
     * 兑换邀请码
     * */
    InvitationCode save(InvitationCode invitationCode);

    /**
     * 校验邀请码是否有效
     * */

    InvitationCode findByCodeAndState(String code,int state);
}
