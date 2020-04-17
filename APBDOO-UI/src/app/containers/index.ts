import {LoginComponent} from "./login/login.component";
import {AppRootComponent} from "./app-root/app-root.component";
import {PostGridComponent} from "./post-grid/post-grid.component";
import {CreatePostComponent} from "./create-post/create-post.component";
import {EditPostComponent} from "./edit-post/edit-post.component";
import {ChipInputComponent} from "./chip-input/chip-input.component";

export const containers: any[] = [
  AppRootComponent,
  LoginComponent,
  PostGridComponent,
  CreatePostComponent,
  EditPostComponent,
  ChipInputComponent
];

export * from "./login/login.component";
export * from "./app-root/app-root.component";
export * from "./post-grid/post-grid.component";
export * from "./create-post/create-post.component";
export * from "./edit-post/edit-post.component";
export * from "./chip-input/chip-input.component";
