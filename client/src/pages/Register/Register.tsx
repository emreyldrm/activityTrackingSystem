import { Field, Form, Formik } from 'formik'
import React from 'react'
import { Link } from 'react-router-dom'
import authService from '../../services/authService'
import { UserPostModel } from '../../models/requests/UserPostModel'
import toastr, { error } from "toastr";

type Props = {}

const Register = (props: Props) => {

  const initialValues:UserPostModel = {
    email: "",
    username: "",
    password: "",
    roles: ["USER"],
    name: "",
    surname: "",
    nationalityId: "",
    birthday: "",
    }

  const handleSubmit = (values: any) => {
    console.log(values.username);
    console.log(values.password);
    const registerData = {
      email: values.email,
      username: values.username,
      password: values.password,
      roles: ["USER"],
      name: values.name,
      surname: values.surname,
      nationalityId: values.nationalityId,
      birthday: values.birthday,
    }
    console.log(registerData);
    authService.register(registerData).then((response) => {
      
      console.log(response);
    }).then((response) => {
       
        console.log(response);
      })
      .catch((error: any) => {
        if (error.response) {
          console.log(error.response)
        }else{

          toastr.success("Register is success");
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
                <strong>Kayıt Ol!</strong>
              </h2>
            </div>
          </div>

          <div className="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">

            <Formik initialValues={initialValues} onSubmit={handleSubmit}>
              <Form autoComplete="off">
                {/* Login */}
                <div className='flex gap-2 pl-16 font-comfortaa flex-col'>
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
                  <div className='flex flex-col'>
                    <div className='text-[16px]  '>Email</div>
                    <div className='border-2 flex flex-row bg-red-500'>
                      <div className=" w-full bg-red-50">
                      <Field type="text" name="email" id="email" className="w-full h-[28px]" />
                      </div>
                    </div>
                  </div>
                  <div className='flex flex-col'>
                    <div className='text-[16px]  '>Name</div>
                    <div className='border-2 flex flex-row bg-red-500'>
                      <div className=" w-full bg-red-50">
                      <Field type="text" name="name" id="name" className="w-full h-[28px]" />
                      </div>
                    </div>
                  </div>
                  <div className='flex flex-col'>
                    <div className='text-[16px]  '>Surname</div>
                    <div className='border-2 flex flex-row bg-red-500'>
                      <div className=" w-full bg-red-50">
                      <Field type="text" name="surname" id="surname" className="w-full h-[28px]" />
                      </div>
                    </div>
                  </div>
                  <div className='flex flex-col'>
                    <div className='text-[16px]  '>Nationatilty ID</div>
                    <div className='border-2 flex flex-row bg-red-500'>
                      <div className=" w-full bg-red-50">
                      <Field type="text" name="nationalityId" id="nationalityId" className="w-full h-[28px]" />
                      </div>
                    </div>
                  </div>
                  <div className='flex flex-col'>
                    <div className='text-[16px]  '>Birthday</div>
                    <div className='border-2 flex flex-row bg-red-500'>
                      <div className=" w-full bg-red-50">
                      <Field type="text" name="birthday" id="birthday" className="w-full h-[28px]" />
                      </div>
                    </div>
                  </div>
                </div>
                <div className="flex justify-center pl-16">
                <div className='flex flex-col mt-10  h-10 w-80 rounded-md bg-zinc-300 justify-center hover:bg-rentYellow  transition duration-500 font-comfortaa text-rentWhite'>
                  <button type='submit' className='tracking-wider'><strong>Register</strong></button>
                </div>
                </div>
              </Form>
            </Formik>
            <div className="flex flex-col justify-center pl-16">
            <p className="mt-5 text-center text-sm text-gray-500">
              <Link
                to={"/login"}

                className="hover:text-rentYellow cursor-pointer transition duration-500"
              >
                Have a account..{" "}
              </Link>
            </p>
            </div>

          </div>
        </div>
      </div>
    </>
  )
}

export default Register