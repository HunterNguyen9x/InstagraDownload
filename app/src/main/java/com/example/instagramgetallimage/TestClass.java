package com.example.instagramgetallimage;

public class TestClass {
    public Data data;
    public String status;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

class Data {
    public User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

class User {
    public Edge_Owner_To_Timeline_Media edge_owner_to_timeline_media;

    public Edge_Owner_To_Timeline_Media getEdge_owner_to_timeline_media() {
        return edge_owner_to_timeline_media;
    }

    public void setEdge_owner_to_timeline_media(Edge_Owner_To_Timeline_Media edge_owner_to_timeline_media) {
        this.edge_owner_to_timeline_media = edge_owner_to_timeline_media;
    }
}

class Edge_Owner_To_Timeline_Media {
    public int count;
    public Page_Info page_info;
    public Edge[] edges;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Page_Info getPage_info() {
        return page_info;
    }

    public void setPage_info(Page_Info page_info) {
        this.page_info = page_info;
    }

    public Edge[] getEdges() {
        return edges;
    }

    public void setEdges(Edge[] edges) {
        this.edges = edges;
    }
}

class Page_Info {
    public boolean has_next_page;
    public String end_cursor;

    public boolean isHas_next_page() {
        return has_next_page;
    }

    public void setHas_next_page(boolean has_next_page) {
        this.has_next_page = has_next_page;
    }

    public String getEnd_cursor() {
        return end_cursor;
    }

    public void setEnd_cursor(String end_cursor) {
        this.end_cursor = end_cursor;
    }
}

class Edge {
    public Node node;

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }
}

class Node {
    public String __typename;
    public String id;
    public Dimensions dimensions;
    public String display_url;
    public Display_Resources1[] display_resources;
    public boolean is_video;
    public boolean should_log_client_event;
    public String tracking_token;
    public Edge_Media_To_Tagged_User edge_media_to_tagged_user;
    public Object accessibility_caption;
    public Edge_Media_To_Caption edge_media_to_caption;
    public String shortcode;
    public Edge_Media_To_Comment edge_media_to_comment;
    public Edge_Media_To_Sponsor_User edge_media_to_sponsor_user;
    public boolean comments_disabled;
    public int taken_at_timestamp;
    public Edge_Media_Preview_Like edge_media_preview_like;
    public Object gating_info;
    public String media_preview;
    public Owner1 owner;
    public Object location;
    public boolean viewer_has_liked;
    public boolean viewer_has_saved;
    public boolean viewer_has_saved_to_collection;
    public boolean viewer_in_photo_of_you;
    public boolean viewer_can_reshare;
    public String thumbnail_src;
    public Thumbnail_Resources[] thumbnail_resources;
    public Edge_Sidecar_To_Children edge_sidecar_to_children;
    public Dash_Info1 dash_info;
    public String video_url;
    public int video_view_count;

    public String get__typename() {
        return __typename;
    }

    public void set__typename(String __typename) {
        this.__typename = __typename;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public String getDisplay_url() {
        return display_url;
    }

    public void setDisplay_url(String display_url) {
        this.display_url = display_url;
    }

    public Display_Resources1[] getDisplay_resources() {
        return display_resources;
    }

    public void setDisplay_resources(Display_Resources1[] display_resources) {
        this.display_resources = display_resources;
    }

    public boolean isIs_video() {
        return is_video;
    }

    public void setIs_video(boolean is_video) {
        this.is_video = is_video;
    }

    public boolean isShould_log_client_event() {
        return should_log_client_event;
    }

    public void setShould_log_client_event(boolean should_log_client_event) {
        this.should_log_client_event = should_log_client_event;
    }

    public String getTracking_token() {
        return tracking_token;
    }

    public void setTracking_token(String tracking_token) {
        this.tracking_token = tracking_token;
    }

    public Edge_Media_To_Tagged_User getEdge_media_to_tagged_user() {
        return edge_media_to_tagged_user;
    }

    public void setEdge_media_to_tagged_user(Edge_Media_To_Tagged_User edge_media_to_tagged_user) {
        this.edge_media_to_tagged_user = edge_media_to_tagged_user;
    }

    public Object getAccessibility_caption() {
        return accessibility_caption;
    }

    public void setAccessibility_caption(Object accessibility_caption) {
        this.accessibility_caption = accessibility_caption;
    }

    public Edge_Media_To_Caption getEdge_media_to_caption() {
        return edge_media_to_caption;
    }

    public void setEdge_media_to_caption(Edge_Media_To_Caption edge_media_to_caption) {
        this.edge_media_to_caption = edge_media_to_caption;
    }

    public String getShortcode() {
        return shortcode;
    }

    public void setShortcode(String shortcode) {
        this.shortcode = shortcode;
    }

    public Edge_Media_To_Comment getEdge_media_to_comment() {
        return edge_media_to_comment;
    }

    public void setEdge_media_to_comment(Edge_Media_To_Comment edge_media_to_comment) {
        this.edge_media_to_comment = edge_media_to_comment;
    }

    public Edge_Media_To_Sponsor_User getEdge_media_to_sponsor_user() {
        return edge_media_to_sponsor_user;
    }

    public void setEdge_media_to_sponsor_user(Edge_Media_To_Sponsor_User edge_media_to_sponsor_user) {
        this.edge_media_to_sponsor_user = edge_media_to_sponsor_user;
    }

    public boolean isComments_disabled() {
        return comments_disabled;
    }

    public void setComments_disabled(boolean comments_disabled) {
        this.comments_disabled = comments_disabled;
    }

    public int getTaken_at_timestamp() {
        return taken_at_timestamp;
    }

    public void setTaken_at_timestamp(int taken_at_timestamp) {
        this.taken_at_timestamp = taken_at_timestamp;
    }

    public Edge_Media_Preview_Like getEdge_media_preview_like() {
        return edge_media_preview_like;
    }

    public void setEdge_media_preview_like(Edge_Media_Preview_Like edge_media_preview_like) {
        this.edge_media_preview_like = edge_media_preview_like;
    }

    public Object getGating_info() {
        return gating_info;
    }

    public void setGating_info(Object gating_info) {
        this.gating_info = gating_info;
    }

    public String getMedia_preview() {
        return media_preview;
    }

    public void setMedia_preview(String media_preview) {
        this.media_preview = media_preview;
    }

    public Owner1 getOwner() {
        return owner;
    }

    public void setOwner(Owner1 owner) {
        this.owner = owner;
    }

    public Object getLocation() {
        return location;
    }

    public void setLocation(Object location) {
        this.location = location;
    }

    public boolean isViewer_has_liked() {
        return viewer_has_liked;
    }

    public void setViewer_has_liked(boolean viewer_has_liked) {
        this.viewer_has_liked = viewer_has_liked;
    }

    public boolean isViewer_has_saved() {
        return viewer_has_saved;
    }

    public void setViewer_has_saved(boolean viewer_has_saved) {
        this.viewer_has_saved = viewer_has_saved;
    }

    public boolean isViewer_has_saved_to_collection() {
        return viewer_has_saved_to_collection;
    }

    public void setViewer_has_saved_to_collection(boolean viewer_has_saved_to_collection) {
        this.viewer_has_saved_to_collection = viewer_has_saved_to_collection;
    }

    public boolean isViewer_in_photo_of_you() {
        return viewer_in_photo_of_you;
    }

    public void setViewer_in_photo_of_you(boolean viewer_in_photo_of_you) {
        this.viewer_in_photo_of_you = viewer_in_photo_of_you;
    }

    public boolean isViewer_can_reshare() {
        return viewer_can_reshare;
    }

    public void setViewer_can_reshare(boolean viewer_can_reshare) {
        this.viewer_can_reshare = viewer_can_reshare;
    }

    public String getThumbnail_src() {
        return thumbnail_src;
    }

    public void setThumbnail_src(String thumbnail_src) {
        this.thumbnail_src = thumbnail_src;
    }

    public Thumbnail_Resources[] getThumbnail_resources() {
        return thumbnail_resources;
    }

    public void setThumbnail_resources(Thumbnail_Resources[] thumbnail_resources) {
        this.thumbnail_resources = thumbnail_resources;
    }

    public Edge_Sidecar_To_Children getEdge_sidecar_to_children() {
        return edge_sidecar_to_children;
    }

    public void setEdge_sidecar_to_children(Edge_Sidecar_To_Children edge_sidecar_to_children) {
        this.edge_sidecar_to_children = edge_sidecar_to_children;
    }

    public Dash_Info1 getDash_info() {
        return dash_info;
    }

    public void setDash_info(Dash_Info1 dash_info) {
        this.dash_info = dash_info;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public int getVideo_view_count() {
        return video_view_count;
    }

    public void setVideo_view_count(int video_view_count) {
        this.video_view_count = video_view_count;
    }
}

class Dimensions {
    public int height;
    public int width;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}

class Edge_Media_To_Tagged_User {
    public Edge1[] edges;

    public Edge1[] getEdges() {
        return edges;
    }

    public void setEdges(Edge1[] edges) {
        this.edges = edges;
    }
}

class Edge1 {
    public Node1 node;

    public Node1 getNode() {
        return node;
    }

    public void setNode(Node1 node) {
        this.node = node;
    }
}

class Node1 {
    public User1 user;
    public float x;
    public float y;

    public User1 getUser() {
        return user;
    }

    public void setUser(User1 user) {
        this.user = user;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}

class User1 {
    public String full_name;
    public String id;
    public boolean is_verified;
    public String profile_pic_url;
    public String username;

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isIs_verified() {
        return is_verified;
    }

    public void setIs_verified(boolean is_verified) {
        this.is_verified = is_verified;
    }

    public String getProfile_pic_url() {
        return profile_pic_url;
    }

    public void setProfile_pic_url(String profile_pic_url) {
        this.profile_pic_url = profile_pic_url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

class Edge_Media_To_Caption {
    public Edge2[] edges;

    public Edge2[] getEdges() {
        return edges;
    }

    public void setEdges(Edge2[] edges) {
        this.edges = edges;
    }
}

class Edge2 {
    public Node2 node;

    public Node2 getNode() {
        return node;
    }

    public void setNode(Node2 node) {
        this.node = node;
    }
}

class Node2 {
    public String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

class Edge_Media_To_Comment {
    public int count;
    public Page_Info1 page_info;
    public Edge3[] edges;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Page_Info1 getPage_info() {
        return page_info;
    }

    public void setPage_info(Page_Info1 page_info) {
        this.page_info = page_info;
    }

    public Edge3[] getEdges() {
        return edges;
    }

    public void setEdges(Edge3[] edges) {
        this.edges = edges;
    }
}

class Page_Info1 {
    public boolean has_next_page;
    public String end_cursor;

    public boolean isHas_next_page() {
        return has_next_page;
    }

    public void setHas_next_page(boolean has_next_page) {
        this.has_next_page = has_next_page;
    }

    public String getEnd_cursor() {
        return end_cursor;
    }

    public void setEnd_cursor(String end_cursor) {
        this.end_cursor = end_cursor;
    }
}

class Edge3 {
    public Node3 node;

    public Node3 getNode() {
        return node;
    }

    public void setNode(Node3 node) {
        this.node = node;
    }
}

class Node3 {
    public String id;
    public String text;
    public int created_at;
    public boolean did_report_as_spam;
    public Owner owner;
    public boolean viewer_has_liked;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getCreated_at() {
        return created_at;
    }

    public void setCreated_at(int created_at) {
        this.created_at = created_at;
    }

    public boolean isDid_report_as_spam() {
        return did_report_as_spam;
    }

    public void setDid_report_as_spam(boolean did_report_as_spam) {
        this.did_report_as_spam = did_report_as_spam;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public boolean isViewer_has_liked() {
        return viewer_has_liked;
    }

    public void setViewer_has_liked(boolean viewer_has_liked) {
        this.viewer_has_liked = viewer_has_liked;
    }
}

class Owner {
    public String id;
    public boolean is_verified;
    public String profile_pic_url;
    public String username;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isIs_verified() {
        return is_verified;
    }

    public void setIs_verified(boolean is_verified) {
        this.is_verified = is_verified;
    }

    public String getProfile_pic_url() {
        return profile_pic_url;
    }

    public void setProfile_pic_url(String profile_pic_url) {
        this.profile_pic_url = profile_pic_url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

class Edge_Media_To_Sponsor_User {
    public Object[] edges;

    public Object[] getEdges() {
        return edges;
    }

    public void setEdges(Object[] edges) {
        this.edges = edges;
    }
}

class Edge_Media_Preview_Like {
    public int count;
    public Edge4[] edges;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Edge4[] getEdges() {
        return edges;
    }

    public void setEdges(Edge4[] edges) {
        this.edges = edges;
    }
}

class Edge4 {
    public Node4 node;

    public Node4 getNode() {
        return node;
    }

    public void setNode(Node4 node) {
        this.node = node;
    }
}

class Node4 {
    public String id;
    public String profile_pic_url;
    public String username;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProfile_pic_url() {
        return profile_pic_url;
    }

    public void setProfile_pic_url(String profile_pic_url) {
        this.profile_pic_url = profile_pic_url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

class Owner1 {
    public String id;
    public String username;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

class Edge_Sidecar_To_Children {
    public Edge5[] edges;

    public Edge5[] getEdges() {
        return edges;
    }

    public void setEdges(Edge5[] edges) {
        this.edges = edges;
    }
}

class Edge5 {
    public Node5 node;

    public Node5 getNode() {
        return node;
    }

    public void setNode(Node5 node) {
        this.node = node;
    }
}

class Node5 {
    public String __typename;
    public String id;
    public Dimensions1 dimensions;
    public String display_url;
    public Display_Resources[] display_resources;
    public boolean is_video;
    public boolean should_log_client_event;
    public String tracking_token;
    public Edge_Media_To_Tagged_User1 edge_media_to_tagged_user;
    public Object accessibility_caption;
    public Dash_Info dash_info;
    public String video_url;
    public int video_view_count;

    public String get__typename() {
        return __typename;
    }

    public void set__typename(String __typename) {
        this.__typename = __typename;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Dimensions1 getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions1 dimensions) {
        this.dimensions = dimensions;
    }

    public String getDisplay_url() {
        return display_url;
    }

    public void setDisplay_url(String display_url) {
        this.display_url = display_url;
    }

    public Display_Resources[] getDisplay_resources() {
        return display_resources;
    }

    public void setDisplay_resources(Display_Resources[] display_resources) {
        this.display_resources = display_resources;
    }

    public boolean isIs_video() {
        return is_video;
    }

    public void setIs_video(boolean is_video) {
        this.is_video = is_video;
    }

    public boolean isShould_log_client_event() {
        return should_log_client_event;
    }

    public void setShould_log_client_event(boolean should_log_client_event) {
        this.should_log_client_event = should_log_client_event;
    }

    public String getTracking_token() {
        return tracking_token;
    }

    public void setTracking_token(String tracking_token) {
        this.tracking_token = tracking_token;
    }

    public Edge_Media_To_Tagged_User1 getEdge_media_to_tagged_user() {
        return edge_media_to_tagged_user;
    }

    public void setEdge_media_to_tagged_user(Edge_Media_To_Tagged_User1 edge_media_to_tagged_user) {
        this.edge_media_to_tagged_user = edge_media_to_tagged_user;
    }

    public Object getAccessibility_caption() {
        return accessibility_caption;
    }

    public void setAccessibility_caption(Object accessibility_caption) {
        this.accessibility_caption = accessibility_caption;
    }

    public Dash_Info getDash_info() {
        return dash_info;
    }

    public void setDash_info(Dash_Info dash_info) {
        this.dash_info = dash_info;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public int getVideo_view_count() {
        return video_view_count;
    }

    public void setVideo_view_count(int video_view_count) {
        this.video_view_count = video_view_count;
    }
}

class Dimensions1 {
    public int height;
    public int width;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}

class Edge_Media_To_Tagged_User1 {
    public Edge6[] edges;

    public Edge6[] getEdges() {
        return edges;
    }

    public void setEdges(Edge6[] edges) {
        this.edges = edges;
    }
}

class Edge6 {
    public Node6 node;

    public Node6 getNode() {
        return node;
    }

    public void setNode(Node6 node) {
        this.node = node;
    }
}

class Node6 {
    public User2 user;
    public float x;
    public float y;

    public User2 getUser() {
        return user;
    }

    public void setUser(User2 user) {
        this.user = user;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}

class User2 {
    public String full_name;
    public String id;
    public boolean is_verified;
    public String profile_pic_url;
    public String username;

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isIs_verified() {
        return is_verified;
    }

    public void setIs_verified(boolean is_verified) {
        this.is_verified = is_verified;
    }

    public String getProfile_pic_url() {
        return profile_pic_url;
    }

    public void setProfile_pic_url(String profile_pic_url) {
        this.profile_pic_url = profile_pic_url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

class Dash_Info {
    public boolean is_dash_eligible;
    public Object video_dash_manifest;
    public int number_of_qualities;

    public boolean isIs_dash_eligible() {
        return is_dash_eligible;
    }

    public void setIs_dash_eligible(boolean is_dash_eligible) {
        this.is_dash_eligible = is_dash_eligible;
    }

    public Object getVideo_dash_manifest() {
        return video_dash_manifest;
    }

    public void setVideo_dash_manifest(Object video_dash_manifest) {
        this.video_dash_manifest = video_dash_manifest;
    }

    public int getNumber_of_qualities() {
        return number_of_qualities;
    }

    public void setNumber_of_qualities(int number_of_qualities) {
        this.number_of_qualities = number_of_qualities;
    }
}

class Display_Resources {
    public String src;
    public int config_width;
    public int config_height;

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public int getConfig_width() {
        return config_width;
    }

    public void setConfig_width(int config_width) {
        this.config_width = config_width;
    }

    public int getConfig_height() {
        return config_height;
    }

    public void setConfig_height(int config_height) {
        this.config_height = config_height;
    }
}

class Dash_Info1 {
    public boolean is_dash_eligible;
    public Object video_dash_manifest;
    public int number_of_qualities;

    public boolean isIs_dash_eligible() {
        return is_dash_eligible;
    }

    public void setIs_dash_eligible(boolean is_dash_eligible) {
        this.is_dash_eligible = is_dash_eligible;
    }

    public Object getVideo_dash_manifest() {
        return video_dash_manifest;
    }

    public void setVideo_dash_manifest(Object video_dash_manifest) {
        this.video_dash_manifest = video_dash_manifest;
    }

    public int getNumber_of_qualities() {
        return number_of_qualities;
    }

    public void setNumber_of_qualities(int number_of_qualities) {
        this.number_of_qualities = number_of_qualities;
    }
}

class Display_Resources1 {
    public String src;
    public int config_width;
    public int config_height;

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public int getConfig_width() {
        return config_width;
    }

    public void setConfig_width(int config_width) {
        this.config_width = config_width;
    }

    public int getConfig_height() {
        return config_height;
    }

    public void setConfig_height(int config_height) {
        this.config_height = config_height;
    }
}

class Thumbnail_Resources {
    public String src;
    public int config_width;
    public int config_height;

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public int getConfig_width() {
        return config_width;
    }

    public void setConfig_width(int config_width) {
        this.config_width = config_width;
    }

    public int getConfig_height() {
        return config_height;
    }

    public void setConfig_height(int config_height) {
        this.config_height = config_height;
    }
}


