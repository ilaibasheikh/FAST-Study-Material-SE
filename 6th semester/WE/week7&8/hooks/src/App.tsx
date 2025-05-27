import { useState } from 'react'
import { useForm } from "react-hook-form";
import { DevTool } from "@hookform/devtools";



function App() {
  


  type FormValues = {
    username: string;
    email: string;
    channel: string;
    social:{
      twitter : "",
      facebook: ""
    };
    phoneNumber: string[];
  };
  const form = useForm<FormValues>({
    defaultValues: {
      username: "NAME",
      email: "EMAIL",
      channel: "CHANNEL",
      social:{
        twitter : "Twitter",
        facebook: "Facebook"
  
      },
      phoneNumber: ["Contact NO  1","Contact No 2"],
    },

  });
  const {register, control,handleSubmit,formState, getValues,setValue} = form;
  const {errors}= formState;
  
  const handleGetValues = () =>{
    console.log("Get Values ,",getValues());

  }

  const handleSetValues = () =>{
    setValue("username", "this is ");

  }
  
  const onSubmit = (data: FormValues) => {
    console.log(data);
  };

  return (
    <div>

      <h1>Login </h1>

      <form onSubmit={handleSubmit(onSubmit)} noValidate>

        <label htmlFor="username">Username</label>
        <input type="text" id="username" {...register("username",{required: "username Required"})} />
        <p>{errors.username?.message}</p> <br/>

        <label htmlFor="email">E-mail</label>
        <input type="email" id="email" {...register("email",{required: "email Required",
              pattern: {
                value:
                  /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/,
                message: "Invalid email format",
                
              }})}/>
              <p>{errors.email?.message}</p> <br/> <br/>

        <label htmlFor="channel">Channel</label>
        <input type="text" id="channel" {...register("channel",{required: "channel name Required"})} />
        <p>{errors.channel?.message}</p> <br/>

        <label htmlFor="channel">Twitter</label>
        <input type="text" id="channel" {...register("social.twitter",{required: "twitter Link  Required"})} />
        <p>{errors.social?.twitter?.message}</p> <br/>

        <label htmlFor="channel">Facebook</label>
        <input type="text" id="channel" {...register("social.facebook",{required: "facebook link Required"})} />
        <p>{errors.social?.facebook?.message}</p> <br/>

        <label htmlFor="channel">Contact 1 </label>
        <input type="text" id="channel" {...register("phoneNumber.0",{required: "Contact 1 Required"})} />
        <p>{errors.phoneNumber?.message}</p> <br/>
        
        <label htmlFor="channel">Contact 2</label>
        <input type="text" id="channel" {...register("phoneNumber.1",{required: "Contact 2 Required"})} />
        <p>{errors.phoneNumber?.message}</p> <br/>

        <button>Submit</button>
        <button type='button' onClick={handleGetValues}>Get Values </button>
        <button type='button' onClick={handleSetValues}>set Values </button>
     
      
      </form>
      <DevTool control={control} />
    </div>
  );
}

export default App


