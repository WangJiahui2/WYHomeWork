package com.wangyi.wyhomework.model.show;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserDTO {
    private String id;
    private String idstr;
    private Integer classX;
    private String screenName;
    private String name;
    private String province;
    private String city;
    private String location;
    private String description;
    private String url;
    private String profileImageUrl;
    private String coverImagePhone;
    private String profileUrl;
    private String domain;
    private String weihao;
    private String gender;
    private Integer followersCount;
    private String followersCountStr;
    private Integer friendsCount;
    private Integer pagefriendsCount;
    private Integer statusesCount;
    private Integer videoStatusCount;
    private Integer videoPlayCount;
    private Integer favouritesCount;
    private String createdAt;
    private Boolean following;
    private Boolean allowAllActMsg;
    private Boolean geoEnabled;
    private Boolean verified;
    private Integer verifiedType;
    private String remark;
    private InsecurityDTO insecurity;
    private Integer ptype;
    private Boolean allowAllComment;
    private String avatarLarge;
    private String avatarHd;
    private String verifiedReason;
    private String verifiedTrade;
    private String verifiedReasonUrl;
    private String verifiedSource;
    private String verifiedSourceUrl;
    private Boolean followMe;
    private Boolean like;
    private Boolean likeMe;
    private Integer onlineStatus;
    private Integer biFollowersCount;
    private String lang;
    private Integer star;
    private Integer mbtype;
    private Integer mbrank;
    private Integer svip;
    private Integer blockWord;
    private Integer blockApp;
    private Integer chaohuaAbility;
    private Integer brandAbility;
    private Integer nftAbility;
    private Integer creditScore;
    private Integer userAbility;
    private Integer urank;
    private Integer storyReadState;
    private Integer vclubMember;
    private Integer isTeenager;
    private Integer isGuardian;
    private Integer isTeenagerList;
    private Integer pcNew;
    private Boolean specialFollow;
    private Integer planetVideo;
    private Integer videoMark;
    private Integer liveStatus;
    private Integer userAbilityExtend;
    private StatusTotalCounterDTO statusTotalCounter;
    private VideoTotalCounterDTO videoTotalCounter;
    private Integer brandAccount;
    private Integer hongbaofei;
    private String tabManage;
    private Integer rewardStatus;
}
