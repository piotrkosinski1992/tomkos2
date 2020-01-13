package com.tomkos2.user.gateway;

import com.tomkos2.user.domain.EntityId;
import com.tomkos2.user.domain.UserInfo;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, EntityId> {

  Optional<UserInfo> findByCredentialsUsername(String username);
}
