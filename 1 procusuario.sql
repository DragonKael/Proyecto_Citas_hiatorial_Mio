set global log_bin_trust_function_creators = 1;
use bd_cita_medica;
--  listar
drop procedure if exists usp_listar_usuario;
drop procedure if exists usp_recuperar_usuario;
drop procedure if exists usp_insertar_usuario;
drop function if exists fn_generar_id_usuario;
drop procedure if exists usp_modificar_usuario;
drop procedure if exists usp_eliminar_usuario;
delimiter XD
	create procedure usp_listar_usuario(pbuscar varchar(50))
		begin
			select *
			from tusuario
			where apaterno like concat('%',pbuscar,'%');
		end XD
	-- funcion generar id usuario

	create function fn_generar_id_usuario()
				returns int
		begin
			set @id_usuario=(select count(*)from tusuario);
				if(@id_usuario=0)then
					return 0;
				else
					begin
						set @id_usuario=(select max(id_usuario)from tusuario)+1;
                        return @id_usuario;
                    end;
				end if;		
	end XD
    -- recuperar
    create procedure usp_recuperar_usuario(pemail varchar(255), 
											pcontrasenia varchar(60))
    begin
			select *
			from tusuario
			where email like pemail and contrasenia like sha1(md5(pcontrasenia));
		end XD
	-- insertar
	create procedure usp_insertar_usuario(pnombre_usuario varchar(50),
											pnombre varchar(50),
											papaterno varchar(50),
											pamaterno varchar(50),
											pemail varchar(255),
											pcontrasenia varchar(60),
											pcreado_en datetime)
		begin
			set @id_usuario=fn_generar_id_usuario();
			if exists(	select *
						from tusuario
						where nombre_usuario=pnombre_usuario)then
				begin
					set @mensaje='error ya existe usuario con ese nombre';
					set @id_error=1;
				end;
			else
				begin
					insert into tusuario values(@id_usuario,
												pnombre_usuario,
												pnombre,
												papaterno,
												pamaterno,
												pemail,
												sha1(md5(pcontrasenia)),
												true,
												false,
												pcreado_en);
					set@mensaje='EXISTOOOOOOOO!!!!!!!!!!!!! LO INSERTASTE CORRECTAMENTE';
					set@id_error=0;
				end;
			end if;
			select @mensaje,@id_error;
            select * from tusuario;
		end XD 
-- modificar
	
    create procedure usp_modificar_usuario(	pid_usuario int,
											pnombre_usuario varchar(50),
											pnombre varchar(50),
											papaterno varchar(50),
											pamaterno varchar(50),
											pemail varchar(255),
											pcontrasenia varchar(60),
											pes_activo boolean,
											pes_administrador boolean,
											pcreado_en datetime)
		begin
			if exists(	select *
						from tusuario
						where nombre_usuario=pnombre_usuario)then
				begin
					set @mensaje='error ya existe el nombre';
					set @id_error=1;
				end;
			else
				begin
					update tusuario set	nombre_usuario=pnombre_usuario,
										nombre=pnombre,
										apaterno=papaterno,
										amaterno=pamaterno,
										email=pemail,
										contrasenia=sha1(md5(pcontrasenia)),
										es_activo=pes_activo,
										es_administrador=pes_administrador,
										creado_en=pcreado_en
						where id_usuario = pid_usuario;
					set@mensaje='EXISTOOOOOOOO!!!!!!!!!!!!! LO MODIFICASTE CORRECTAMENTE';
					set@id_error=0;
				end;
			end if;
			select @mensaje,@id_error;
            select * from tusuario;
		end XD 
-- eliminar

	create procedure usp_eliminar_usuario(pid_usuario int)
		begin
			if exists (select * from tusuario where id_usuario=pid_usuario)then
				if not exists(select * from treserva where id_usuario=pid_usuario)then
						delete from tusuario where id_usuario=pid_usuario;
					begin
						set @mensaje='existo';
						set @id_error=0;
					end;
				else
					begin
						set @mensaje='error se encuentra en la tabla reservacion';
						set @id_error=1;
					end;
				end if;
			else
				begin
					set @mensaje='no existe usuario';
					set @id_error=1;
				end;
			end if;
			select @mensaje,@id_error;
            select * from tusuario;
		end XD
        call usp_insertar_usuario("","","","","","admin",NOW());
        call usp_modificar_usuario("0","CREADOR",'','','','sofichin3000@hotmail.com',"dragonkael",true,true,now());
        -- call usp_eliminar_usuario(0);
        -- select * from tmodificado;