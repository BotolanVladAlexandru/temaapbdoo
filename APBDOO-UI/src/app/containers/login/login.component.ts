import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {AuthService} from "../../services";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  invalidCredentials = false;
  invalidForm = false;
  loginForm = new FormGroup({
      username: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required)
    }
  );

  constructor(private router: Router,
              private loginService: AuthService) {
  }

  ngOnInit() {
  }

  checkLogin() {
    (this.loginService.authenticate(
        this.loginForm.get('username').value,
        this.loginForm.get('password').value
      ).subscribe(
        () => {
          this.invalidCredentials = false;
          this.invalidForm = false;
          this.router.navigate(['posts']);
        },
        () => {
          if(!this.loginForm.valid){
            this.invalidCredentials = false;
            this.invalidForm = true;
          } else{
            this.invalidCredentials = true;
            this.invalidForm = false;
          }
        }
      )
    );
  }
}
