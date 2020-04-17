import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {CreatePostComponent, EditPostComponent, LoginComponent, PostGridComponent} from "./containers";

const routes: Routes = [
  {
    path: '',
    children: [
      {
        path: 'posts',
        component: PostGridComponent,
      },
      {
        path: 'login',
        component: LoginComponent
      },
      {
        path: 'post',
        component: CreatePostComponent
      },
      {
        path: 'post/:id',
        component: EditPostComponent
      },
    ],
  },
  {path: '**', redirectTo: '/login'},
];


@NgModule({
  imports: [
    RouterModule.forRoot(routes, {onSameUrlNavigation: 'reload'}),
  ],
  exports: [RouterModule],
})
export class AppRouterModule {
}
