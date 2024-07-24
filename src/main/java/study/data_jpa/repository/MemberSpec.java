package study.data_jpa.repository;

import ch.qos.logback.core.util.StringUtil;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;
import study.data_jpa.entity.Member;
import study.data_jpa.entity.Team;

public class MemberSpec {

    public static Specification<Member> teamName(final String teamName) {
        return (Specification<Member>) (root, query, builder) -> {

            if (StringUtil.isNullOrEmpty(teamName)) {
                return null;
            }

            Join<Member, Team> t = root.join("team", JoinType.INNER);
            return builder.equal(t.get("name"), teamName);
        };
    }

    public static Specification<Member> username(final String username) {
        return (Specification<Member>) (root, query, builder) ->
                builder.equal(root.get("username"), username);
    }
}
