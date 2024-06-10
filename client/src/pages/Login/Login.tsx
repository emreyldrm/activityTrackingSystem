import axios from "axios";
import { Field, Form, Formik } from "formik";
import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import authService from "../../services/authService";
import toastr, { error } from "toastr";
import { useAuth } from "./AuthContext";


type Props = {};

const Login = (props: Props) => {



  

  const initialValues = {
    username: "",
    password: "",
  }
  const navigate = useNavigate();

  // const [login, setLogin] = useState({
  //   username: "",
  //   password: "",
  // });

  const handleSubmit = (values: any) => {
    console.log(values.username);
    console.log(values.password);
    const loginData = {
      username: values.username,
      password: values.password,
    }
    console.log(loginData);
    authService.login(loginData).then((response) => {
      console.log(response.data + "AAAAAA");
      
      localStorage.setItem("jwtToken",response.data.message),
      localStorage.setItem("currentUser", response.data.userId)
      toastr.success("Login is success");
      setTimeout(() => {
        navigate('/events'); // /events sayfasına yönlendir
      }, 2000);
    }).catch((error: any) => {
        if (error.response) {
          console.log(error)
          toastr.error("Login failed");
        }
      })
  }

  return (
    <>
      <div className="flex min-h-full flex-1 lg:flex-row font-comfortaa">
        {/* Sol Yarısı (Form) */}
        <div className="flex-1 flex-col justify-center px-6 py-20 lg:px-8">
          <div className="sm:mx-auto sm:w-full sm:max-w-sm">
            <div className="pl-[60px]">
              <h2 className="mt-10 text-center text-4xl font-bold leading-9 tracking-tight text-gray-900 font-comfortaa">
                <strong>Giriş Yap!</strong>
              </h2>
            </div>
          </div>

          <div className="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">

            <Formik initialValues={initialValues} onSubmit={handleSubmit}>
              <Form autoComplete="off">
                {/* Login */}
                <div className='flex gap-8 pl-16 font-comfortaa flex-col'>
                  <div className='flex flex-col'>
                    <div className='text-[16px]  '>Username</div>
                    <div className='border-2 flex flex-row bg-red-500'>
                      <div className=" w-full bg-red-50">
                      <Field type="text" name="username" id="username" className="w-full h-[28px]" />
                      </div>
                    </div>
                  </div>
                  <div className='flex flex-col'>
                    <div className='text-[16px]'>Password</div>
                    <div className='border 2'>
                      <Field type="password" name="password" id="password" className="w-full h-[28px]" />
                    </div>
                  </div>
                </div>
                <div className="flex justify-center pl-16">
                <div className='flex flex-col mt-10  h-10 w-80 rounded-md bg-zinc-300 justify-center hover:bg-rentYellow  transition duration-500 font-comfortaa text-rentWhite'>
                  <button type='submit' className='tracking-wider'><strong>Login</strong></button>
                </div>
                </div>
              </Form>
            </Formik>
            <div className="flex flex-col justify-center pl-16">
            <p className="mt-5 text-center text-sm text-gray-500">
              <Link
                to={"/register"}

                className="hover:text-rentYellow cursor-pointer transition duration-500"
              >
                Not a member?{" "}
              </Link>
            </p>
            </div>

          </div>
        </div>
      </div>
    </>
  );
};

export default Login;
