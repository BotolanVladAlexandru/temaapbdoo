export interface Post {
  id: string;
  title: string;
  text: string;
  tagModel?: Tag;
  tag?: string;
  categoryModels?: Category[];
  categoryNames?: string;
  locationModel?: Location;
  importanceModel?: Importance;
  siteModels?: Site[]
  siteNames?: string;
}

export interface Tag {
  id?: string;
  name: string;
}

export interface Category {
  id?: string;
  name: string;
}

export interface Location {
  id?: string;
  name: string;
}

export interface Importance {
  id?: string;
  name: string;
}

export interface Site {
  id?: string;
  name: string;
}
