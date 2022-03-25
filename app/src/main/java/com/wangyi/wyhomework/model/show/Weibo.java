package com.wangyi.wyhomework.model.show;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Weibo {

    private VisibleDTO visible;
    private String createdAt;
    private Long id;
    private String idstr;
    private String mid;
    private Boolean canEdit;
    private Integer showAdditionalIndication;
    private String text;
    private Integer textLength;
    private Integer sourceAllowclick;
    private Integer sourceType;
    private String source;
    private Boolean favorited;
    private Boolean truncated;
    private String inReplyToStatusId;
    private String inReplyToUserId;
    private String inReplyToScreenName;
    private List<PicUrlsDTO> picUrls;
    private String thumbnailPic;
    private String bmiddlePic;
    private String originalPic;
    private Object geo;
    private Boolean isPaid;
    private Integer mblogVipType;
    private UserDTO user;
    private List<AnnotationsDTO> annotations;
    private String picStatus;
    private Integer repostsCount;
    private Integer commentsCount;
    private Integer reprintCmtCount;
    private Integer attitudesCount;
    private Integer pendingApprovalCount;
    private Boolean isLongText;
    private Integer rewardExhibitionType;
    private Integer hideFlag;
    private Integer mlevel;
    private Long bizFeature;
    private Integer hasActionTypeCard;
    private List<?> darwinTags;
    private List<?> hotWeiboTags;
    private List<?> textTagTips;
    private Integer mblogtype;
    private Integer userType;
    private Integer moreInfoType;
    private NumberDisplayStrategyDTO numberDisplayStrategy;
    private Integer positiveRecomFlag;
    private Boolean enableCommentGuide;
    private Integer contentAuth;
    private String gifIds;
    private Integer isShowBulletin;
    private CommentManageInfoDTO commentManageInfo;
    private Integer picNum;
    private AlchemyParamsDTO alchemyParams;
    private Integer reprintType;
    private Boolean canReprint;
    private Integer newCommentStyle;
}
