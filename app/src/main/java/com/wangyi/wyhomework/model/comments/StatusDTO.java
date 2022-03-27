package com.wangyi.wyhomework.model.comments;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class StatusDTO {
    @JSONField(name = "visible")
    private VisibleDTO visible;
    @JSONField(name = "created_at")
    private String createdAt;
    @JSONField(name = "id")
    private String id;
    @JSONField(name = "idstr")
    private String idstr;
    @JSONField(name = "mid")
    private String mid;
    @JSONField(name = "can_edit")
    private Boolean canEdit;
    @JSONField(name = "show_additional_indication")
    private Integer showAdditionalIndication;
    @JSONField(name = "text")
    private String text;
    @JSONField(name = "textLength")
    private Integer textLength;
    @JSONField(name = "source_allowclick")
    private Integer sourceAllowclick;
    @JSONField(name = "source_type")
    private Integer sourceType;
    @JSONField(name = "source")
    private String source;
    @JSONField(name = "favorited")
    private Boolean favorited;
    @JSONField(name = "truncated")
    private Boolean truncated;
    @JSONField(name = "in_reply_to_status_id")
    private String inReplyToStatusId;
    @JSONField(name = "in_reply_to_user_id")
    private String inReplyToUserId;
    @JSONField(name = "in_reply_to_screen_name")
    private String inReplyToScreenName;
    @JSONField(name = "pic_urls")
    private List<PicUrlsDTO> picUrls;
    @JSONField(name = "thumbnail_pic")
    private String thumbnailPic;
    @JSONField(name = "bmiddle_pic")
    private String bmiddlePic;
    @JSONField(name = "original_pic")
    private String originalPic;
    @JSONField(name = "geo")
    private Object geo;
    @JSONField(name = "is_paid")
    private Boolean isPaid;
    @JSONField(name = "mblog_vip_type")
    private Integer mblogVipType;
    @JSONField(name = "user")
    private UserDTO user;
    @JSONField(name = "annotations")
    private List<AnnotationsDTO> annotations;
    @JSONField(name = "reposts_count")
    private Integer repostsCount;
    @JSONField(name = "comments_count")
    private Integer commentsCount;
    @JSONField(name = "reprint_cmt_count")
    private Integer reprintCmtCount;
    @JSONField(name = "attitudes_count")
    private Integer attitudesCount;
    @JSONField(name = "pending_approval_count")
    private Integer pendingApprovalCount;
    @JSONField(name = "isLongText")
    private Boolean isLongText;
    @JSONField(name = "reward_exhibition_type")
    private Integer rewardExhibitionType;
    @JSONField(name = "reward_scheme")
    private String rewardScheme;
    @JSONField(name = "hide_flag")
    private Integer hideFlag;
    @JSONField(name = "mlevel")
    private Integer mlevel;
    @JSONField(name = "biz_feature")
    private Long bizFeature;
    @JSONField(name = "page_type")
    private Integer pageType;
    @JSONField(name = "hasActionTypeCard")
    private Integer hasActionTypeCard;
    @JSONField(name = "darwin_tags")
    private List<?> darwinTags;
    @JSONField(name = "hot_weibo_tags")
    private List<?> hotWeiboTags;
    @JSONField(name = "text_tag_tips")
    private List<?> textTagTips;
    @JSONField(name = "mblogtype")
    private Integer mblogtype;
    @JSONField(name = "userType")
    private Integer userType;
    @JSONField(name = "more_info_type")
    private Integer moreInfoType;
    @JSONField(name = "number_display_strategy")
    private NumberDisplayStrategyDTO numberDisplayStrategy;
    @JSONField(name = "positive_recom_flag")
    private Integer positiveRecomFlag;
    @JSONField(name = "content_auth")
    private Integer contentAuth;
    @JSONField(name = "gif_ids")
    private String gifIds;
    @JSONField(name = "is_show_bulletin")
    private Integer isShowBulletin;
    @JSONField(name = "comment_manage_info")
    private CommentManageInfoDTO commentManageInfo;
    @JSONField(name = "pic_num")
    private Integer picNum;
    @JSONField(name = "alchemy_params")
    private AlchemyParamsDTO alchemyParams;
    @JSONField(name = "reprint_type")
    private Integer reprintType;
    @JSONField(name = "can_reprint")
    private Boolean canReprint;
    @JSONField(name = "new_comment_style")
    private Integer newCommentStyle;
}
