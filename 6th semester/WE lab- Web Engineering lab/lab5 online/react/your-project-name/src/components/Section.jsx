const Section = ({ id, title, bgColor }) => {
    return (
      <div id={id} className={`h-screen flex items-center justify-center ${bgColor}`}>
        <h1 className="text-4xl font-bold">{title}</h1>
      </div>
    );
  };
  
  export default Section;
  